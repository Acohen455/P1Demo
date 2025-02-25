import { Button, Container, Form } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import {useEffect, useRef} from "react";

export const Login:React.FC = () => {

    //we can use the useNavigate hook to navigate between components programatically
        //(no more manual URL changing)
    const navigate = useNavigate()

    //using useref to grab focus
    const usernameRef = useRef<HTMLInputElement>(null);

    useEffect(() => {

        if (usernameRef.current){
            usernameRef.current.focus()
        }

    }, []);

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
                        ref={usernameRef} //attach our usernameRef here
                        //this is how our useref knows what to focus
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