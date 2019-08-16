import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import rootReducer from "./reducers";

const inititalState = {};
const middleware = [thunk];

const ReactReduxDevTools =
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__();
let store;

if (ReactReduxDevTools) {
  store = createStore(
    rootReducer,
    inititalState,

    compose(
      applyMiddleware(...middleware),
      ReactReduxDevTools
    )
  );
} else {
  store = createStore(
    rootReducer,
    inititalState,
    compose(applyMiddleware(...middleware))
  );
}

export default store;
