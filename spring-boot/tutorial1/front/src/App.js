import './App.css';

import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import MenuBar from './components/MenuBar';

export const App = () => {
  return (
       <div className="App">
          <MenuBar></MenuBar>
          <Router>
      <div>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
          <li>
            <Link to="/dashboard">Dashboard</Link>
          </li>
        </ul>

        <hr />

        {/*
          A <Switch> looks through all its children <Route>
          elements and renders the first one whose path
          matches the current URL. Use a <Switch> any time
          you have multiple routes, but you want only one
          of them to render at a time
        */}
        <Routes>
          <Route exact path="/">
          </Route>
          <Route path="/about">
          </Route>
          <Route path="/dashboard">
          </Route>
        </Routes>
      </div>
    </Router>
         
       </div>
  )
}



export default App;
