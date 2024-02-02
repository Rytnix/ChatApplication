import Login from './components/Auth/Login';
import Signup from './components/Auth/Signup';
import { Routes, Route } from "react-router-dom";
import HomePage from './components/Home/HomePage';

function App() {
  return (
    <div className="">

      <Routes>
       <Route path="/" element={<HomePage/>}></Route>
        <Route path="/signup" element={<Signup/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
      </Routes>
      
    </div>
  );
}

export default App;
