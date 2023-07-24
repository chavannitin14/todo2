import React, { Component } from "react";
import {
  Button,
  ButtonGroup,
  Container,
  Table,
  Check,
  Input,
} from "reactstrap";
import AppNavbar from "./AppNavbar";
import { MDBIcon } from "mdb-react-ui-kit";
import TaskEdit from "./TaskEdit";

class TaskList extends Component {
  constructor(props) {
    super(props);
    this.state = { tasks: [] };
    this.removeTask = this.removeTask.bind(this);
  }
  componentDidMount() {
    const user = this.props["user"];
    const { tasks } = this.state;
    try {
      fetch(`/user/${user.userId}/tasks`)
        .then((response) => {
          // Unfortunately, fetch doesn't send (404 error) into the cache itself
          // You have to send it, as I have done below
          if (response.status >= 400) {
            throw new Error("Server responds with error!");
          }
          return response.json();
        })
        .then(
          (data) => {
            this.setState({ tasks: data._embedded.tasks });
          },
          (error) => console.log("Error loading tasks")
        );
    } catch {
      alert("Error");
    }
    this.removeTask = this.removeTask.bind(this);
  }

  async removeTask(task) {
    await fetch(`user/${task.userId}/tasks/${task.taskId}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then(() => {
      let updatedTasks = [...this.state.tasks].filter(
        (i) => i.taskId !== task.taskId
      );
      this.setState({ tasks: updatedTasks });
    });
  }
  render() {
    const { tasks } = this.state;
    const user = this.props["user"];
    const taskList = tasks.map((task) => {
      return (
        <tr key={task.taskId}>
          <td style={{ whiteSpace: "nowrap" }}>
            {task.title}</td>
          <td>
            <ButtonGroup>
              <Button size="sm" color="primary">
                <MDBIcon fas icon="pen" />
              </Button>
              <Button
                size="sm"
                color="danger"
                onClick={() => this.removeTask(task)}
              >
                <MDBIcon fas icon="trash" />
              </Button>
            </ButtonGroup>
          </td>
        </tr>
      );
    });
    return (
      <div>
        <AppNavbar />
        <Container fluid>
          <h3>Tasks</h3>
          <Table className="mt-4 mb-0">
            <thead>
              <tr>
                <td>Tasks</td>
              </tr>
            </thead>
            <tbody>{taskList}</tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default TaskList;
