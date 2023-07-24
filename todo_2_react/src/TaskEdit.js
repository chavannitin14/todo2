import React, { Component } from "react";
import {
  Button,
  Container,
  Form,
  FormGroup,
  Input,
  Label,
  Table,
  ButtonGroup,
  Alert,
} from "reactstrap";
import { MDBIcon } from "mdb-react-ui-kit";
class TaskEdit extends Component {
  newTask = {
    description: "",
    dueDate: new Date(),
    reminder: true,
    reminderDate: new Date(),
    title: "",
    userId: 1,
  };

  constructor(props) {
    super(props);
    this.state = {
      task: this.newTask,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.clearInput = this.clearInput.bind(this);
  }

  async componentDidMount() {
    if (this.props.taskId !== "new") {
      const task = await (
        await fetch(
          `/users/${this.props.user.userId}/tasks/${this.props.taskId}`
        )
      ).json();
      this.setState({ task: task });
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.clearInput = this.clearInput.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const title = target.title;
    let task = { ...this.state.task };
    task["title"] = value;
    this.setState({ task });
  }

  handleSubmit() {
    const { task } = this.state;
    task["userId"] = this.props.user.userId;
    fetch("/task", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(task),
    })
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
          //let updatedTasks = this.state.tasks.push(data)
          //this.setState({ tasks: updatedTasks });
        },
        (error) => console.log("Error loading tasks")
      );
  }

  clearInput() {
    this.setState({ task: this.newTask });
  }

  render() {
    const { task } = this.state;
    return (
      <Container fluid>
        <Table>
          <tbody>
            <tr key={task.taskId}>
              <td style={{ whiteSpace: "nowrap" }}>
                <Input 
                  type="text"
                  id="title"
                  value={task.title || ""}
                  onChange={this.handleChange}
                />
              </td>
              <td>
                <ButtonGroup>
                  <Button
                    size="sm"
                    color="primary"
                    onClick={() => this.handleSubmit()}
                  >
                    <MDBIcon fas icon="check" />
                  </Button>
                  <Button
                    size="sm"
                    color="danger"
                    onClick={() => this.clearInput()}
                  >
                    <MDBIcon fas icon="cancel" />
                  </Button>
                </ButtonGroup>
              </td>
              
              <td className="ml-4"></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </Table>
      </Container>
    );
  }
}

export default TaskEdit;
