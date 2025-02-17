import {Container, Table} from "react-bootstrap";
import {useEffect, useState} from "react";
import axios from "axios";
import {User} from "../../Interfaces/User.ts";


export const UserTable: React.FC = () => {

    //state object to store the user array
    const [users, setUsers] = useState<User[]>([]);

    //useEffect - we'll call a GET request for all users when the component loads
    useEffect(() => {
        //TODO: make sure the user is a manager, redirect them to login if not
            getAllUsers();
    }, []); //we want this to run once on load -- if we wanted it to run on something happening, we would put something in the []



    //Function to get all users from the backend  (HTTP requests)
    const getAllUsers = async () => {

    try{
        const response = await axios.get("http://localhost:8080/users");

        //TODO: error throwing code


        console.log(response.data) //logging the data just to make sure things are working

        //store the users in our state block
        setUsers(response.data);

    } catch {
        alert("Something went wrong trying to fetch users");
    }

    }

    return(
        <Container>
            <h3>Users:</h3>
            <Table className="table-dark table-hover table-striped">
                <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                    {users.map((user:User) => ( //() arrow functions have an implicit return, {} have an explicit return
                        <tr key={user.userId}>
                            <td>{user.userId}</td>
                            <td>{user.username}</td>
                            <td>{user.role}</td>
                        </tr>
                    ))} {/* we are returning something implicit from the arrow function, so we use () for the arrow function*/}
                </tbody>
            </Table>
        </Container>
    )
}