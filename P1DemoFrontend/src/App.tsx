
import './App.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Login} from "./Components/LoginRegister/Login.tsx";
//required manual import for bootstrap to work
import 'bootstrap/dist/css/bootstrap.css';
import {Register} from "./Components/LoginRegister/Register.tsx";
import {UserTable} from "./Components/User/UserTable.tsx";

function App() {


  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* empty string or / for path makes the component render on startup */}
            <Route path="" element={<Login />} />
            <Route path="register" element ={<Register />} />
            <Route path="users" element={<UserTable />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
