import { combineReducers } from "redux";
import errorsReducer from "./errorsReducer";
import projectTaskReducer from "./ProjectTaskReducer";
export default combineReducers({
  errors: errorsReducer,
  project_task: projectTaskReducer
});
