import React from 'react';
import Card from 'react-bootstrap/Card'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Col, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom'
import img1 from '../../images/cover.jpeg';
import './Contact.css';

function Contact() {
    return (
        <>
            <header>
                <h1>Aspirant</h1>
                <nav class="nav" id="myTopnav">
                    <Link to='/home'>Home</Link>
                    <Link to='/about'>About</Link>
                    <Link to='/jobs'>Jobs</Link>
                    <Link to='/contact'>Contact</Link>
                </nav>
            </header>
            <div class="container">
                <Container>
                    <Col md="12">
                        <Card>
                            <Card.Body>
                                <Card.Text>
                                    <div id="container">
                                    <h3> Contact Us</h3>
                                        <form action="#" method="post" id="contact_form">
                                            <div class="name">
                                                <label for="name"></label>
                                                <input type="text" placeholder="My name is" name="name" id="name_input" required />
                                            </div>
                                            <div class="email">
                                                <label for="email"></label>
                                                <input type="email" placeholder="My e-mail is" name="email" id="email_input" required />
                                            </div>
                                            <div class="telephone">
                                                <label for="name"></label>
                                                <input type="text" placeholder="My number is" name="telephone" id="telephone_input" required />
                                            </div>
                                            <div class="telephone">
                                                <label for="message"></label>
                                                <input type="text" name="message" placeholder="I'd like to chat about" id="message_input" required/>
                                            </div>
                                            <div class="submit">
                                                <input type="submit" value="Send Message" id="form_button" />
                                            </div>
                                        </form>
                                    </div>
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                </Container>
            </div>
            <footer>
                <ul>
                    <li>Tel: <a href="telto:(617)-922 2434">(617)-922 2434</a></li>
                    <li>Address: Boston, MA</li>
                    <li>Mail to: <a href="mailto:hr@aspirants.com">hr@aspirants.com</a></li>
                </ul>
            </footer>
        </>
    )
}

export default Contact