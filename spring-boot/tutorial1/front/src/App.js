import './App.css';

import React from 'react'
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
} from "react-router-dom";
import MenuBar from './components/MenuBar';

export const App = () => {
  return (
       <div className="App">
         <MenuBar></MenuBar>
         <hr/>
         <Routes>
         <Route exact path="/">
          </Route>
          <Route path="/about">
          </Route>
          <Route path="/dashboard">
          </Route> 
         </Routes>

    
      
       </div>
  )
}



export default App;
