import React from "react";
import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/Navbar";
import ProjectBoard from "./components/ProjectBoard";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProjectTask from "./components/ProjectTask/AddProjectTask";
import UpdateProjectTask from "./components/ProjectTask/UpdateProjectTask";
import { Provider } from "react-redux";
import store from "./store";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Navbar />
          <Route exact path="/" component={ProjectBoard} />
          <Route exact path="/AddProjectTask" component={AddProjectTask} />
          <Route
            exact
            path="/UpdateProjectTask/:pt_id"
            component={UpdateProjectTask}
          />
          />
        </div>
      </Router>
    </Provider>
  );
}

export default App;
