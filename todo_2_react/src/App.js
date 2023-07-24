import { Button, ButtonGroup, Container, Table } from "reactstrap/es";
import { MDBIcon } from 'mdb-react-ui-kit';
import TaskList from './TasksList';
import TaskEdit from './TaskEdit';

const { Component } = require("react");

var localUserDet = localStorage.getItem('USER_DET');
localUserDet = localUserDet ? JSON.parse(localUserDet) : localUserDet;
var userId = 1;
if(localUserDet)
  userId = localUserDet.userId;

 const testUser = {
    name: 'test',
    userId:userId
  }
class App extends Component {
  async componentDidMount() {
  }
  render() {
    return (
      <div className="App">
        <Container fluid>
          <div className="float-right">
            <TaskList user = {testUser}></TaskList>
            <TaskEdit user = {testUser} taskId ={'new'}></TaskEdit>
          </div>
        </Container>
      </div>
    );
  }
}

export default App;
