
//standard react component component
import {Button, Container, Form} from "react-bootstrap";
import {useNavigate} from "react-router-dom";

export const Login:React.FC = () => {


    //we can use useNavigate hook to navigate between components programatically
    //variable stores the hook
    //we can now use the hook in our app
    const navigate = useNavigate();

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
                />
            </div>

            <div>
                <Form.Control
                    type="password"
                    placeholder="password"
                    name="password"
                />
            </div>


            <Button className="btn-success m-1">Login</Button>
            <Button className="btn-dark" onClick={()=>navigate("/register")}>Register</Button>
        </Container>
    )

}