import {Button, Container, Form} from "react-bootstrap";
import axios from "axios";



export const Register:React.FC = () => {


    //TODO: gather user input like with hypot calculator

    //Hardcoding a new user registration with axios
    //axios is a way to send HTTP requests from React
    const register = async () => {
        //POST request with hardcoded user info
        //axios takes the URL we're going to send to, the data we're sending (if any), and the config
        try {
            const response = await axios.post("http://localhost:8080/auth/register",
                {username:"reactUser", password:"password"});
        } catch {
            alert("Registration Failed");
        }

    }


    return(
        <Container>
            <div>
                <h1>New here? Create an Account for free!</h1>

                <div>
                    <Form.Control
                        type="text"
                        placeholder="username"
                        name="username"
                    />
                </div>
                <div>
                    <Form.Control
                        type="password"
                        placeholder="password"
                        name="password"
                    />
                </div>

                <div>
                    {/*TODO: buttons*/}
                    <Button onClick={register}>Create Account </Button>
                </div>
            </div>
        </Container>
    )

}