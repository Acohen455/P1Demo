
//standard react component component
import {Button, Container, Form} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import {useState} from "react";
import axios from "axios";
import {store} from "../../GlobalData/store.ts";

export const Login:React.FC = () => {


    //we can use useNavigate hook to navigate between components programatically
    //variable stores the hook
    //we can now use the hook in our app
    const navigate = useNavigate();




    //Defining a state object to store the user's info
    const[loginCreds, setLoginCreds] = useState({
        username: "",
        password: ""
    }) // could have defined an interface for this, but we didnt


    //Function to store user inputs
    //we'll have to bind this to the input box
    const storeValues = (event:React.ChangeEvent<HTMLInputElement>) => {
        //store the name (ie. the name of the box) and value of the inputs for ease of use below
        const name = event.target.name; //name is an attribute we set on the target boxes
        const value = event.target.value; //value is the actual value in the input at the time


        //this says:
        //"Take whatever input was changed, and set the matching state field to the value of that input
        //the ... is destructuring
        //setLoginCreds is the mutator
        //pass in the state value
        //destructure logincreds so we can access each value individually
        //then based on the name of the value changed, set that value
        //[name] can be EITHER username or password. This ugly code lends flexibility
        //we destructure the logincreds object to get the name of the user and password fields
        //this syntax is less necessary with only 2 fields, but much more useful with more fields

        //this is the best way to do it
        //get used to the spread operator
        setLoginCreds((loginCreds) => ({...loginCreds, [name]:value}));



    }

    //Function to make the actual login request
    //navigates to /users if a manager logged in, and /games if a user logged in
    const login = async () => {
        //TODO: Make sure the username/password are present before proceeding

        try {
            //axios call for the login request
            //axios requests take a third parameter: withcredentials
            const response = await axios.post("http://localhost:8080/auth/login", loginCreds, {withCredentials: true});
            //withCredentials lets us interact with sessions on the backend
            //every request that depends ont he user being logged in, being an admin, etc. needs this
            //basically passes the session cookie along


            //if the Catch doesnt run, login was successful -- we then need to save data to the global store
            //after this we switch rendered views
            store.loggedInUser = response.data; //this is our logged in user data from the backend -- ie. the http response body
            //axios turns the response body into JSON for us, without us doing anything extra

            //greet the user with this newly stored data
            alert("Welcome, " + store.loggedInUser.username + "!");

            //users will get sent to the users component if theyre an "admin"
            //users will get sent to the game component if theyre a "user"
            if (store.loggedInUser.role === "admin") {
                navigate("/users");
            } else {
                navigate("/games");
            }



        } catch {
            alert("Login Failed");
        }

    }

    return(
        /*Bootstrap gives us this Container element that does some default padding and centering*/
        <Container>

            <h1>Welcome</h1>
            <h3>Please Log In:</h3>

            <div>
                <Form.Control
                    type="text"
                    placeholder="username"
                    name="username"
                    onChange={storeValues}
                />
            </div>

            <div>
                <Form.Control
                    type="password"
                    placeholder="password"
                    name="password"
                    onChange={storeValues}
                />
            </div>


            <Button className="btn-success m-1" onClick={login}>Login</Button>
            <Button className="btn-dark" onClick={()=>navigate("/register")}>Register</Button>
        </Container>
    )

}