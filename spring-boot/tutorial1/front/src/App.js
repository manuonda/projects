import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';




import React from 'react'
import {
  Routes,
  Route,
} from "react-router-dom";
import MenuBar from './components/MenuBar';
import  CreateBlog  from './components/CreateBlog';
import ListBlog from './components/ListBlog';
import EditBlog from './components/EditBlog';

export const App = () => {
  return (
       <div className="App">
         <MenuBar></MenuBar>
         <hr/>
         <Routes>
         <Route exact path="/" element={<ListBlog></ListBlog>} />
          <Route exact path="/edit/:id" element={<EditBlog></EditBlog>}/>
          <Route exact path="/create" element={<CreateBlog></CreateBlog>}/>
         </Routes>

    
      
       </div>
  )
}



export default App;
