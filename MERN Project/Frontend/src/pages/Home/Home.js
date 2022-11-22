import React, { useState, useEffect } from 'react';
import Accordion from 'react-bootstrap/Accordion';
import { useAccordionButton } from 'react-bootstrap/AccordionButton';
import Card from 'react-bootstrap/Card'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Col, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom'
import img1 from '../../images/cover.jpeg';
import './Home.css';

function CustomToggle({ children, eventKey }) {
    const decoratedOnClick = useAccordionButton(eventKey, () =>
        console.log('totally custom!'),
    );

    return (
        <button
            type="button"
            style={{ backgroundColor: '#80b1ca' }}
            onClick={decoratedOnClick}
        >
            {children}
        </button>
    );
}

function Home() {
    const [data, setData] = useState([]);

    useEffect(() => {
        fetch(`http://localhost:3001/user/getAll`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        }).then(function (response) {
            return response.json();
        }).then(function (res) {
            setData(res);
        });
    }, []);

    return (
        <>
            <header>
                <h1>Aspirant<span class="logout"><Button className="btn"><Link to='/' className='link'>Logout</Link></Button></span></h1>
                <nav class="nav" id="myTopnav">
                    <Link to='/home'>Home</Link>
                    <Link to='/about'>About</Link>
                    <Link to='/jobs'>Jobs</Link>
                    <Link to='/contact'>Contact</Link>
                </nav>
            </header>
            <div class="container">
                <Container>
                    <Col md="8">
                        <h3></h3>
                        <Card>
                            <Card.Img variant="top" src={img1} height='250px' width='600px' style={{marginLeft:"50px"}}/>
                            <Card.Body>
                                <Card.Title>Want to get placed?</Card.Title>
                                <Card.Text>
                                    Get ready to see the best job search sites, ranked. But first—
                                    It's the modern age. Your job hunt is now powered with AI, the internet, and 4 billion years of evolution. The problem? So is everybody else's. Plus, you'll need to cut through an impenetrable mass of spam.
                                    <br /><br />
                                    <Accordion defaultActiveKey="0">
                                        <Card>
                                            <Card.Header>
                                                <CustomToggle eventKey="0">List of Aspirants</CustomToggle>
                                            </Card.Header>
                                            <Accordion.Collapse eventKey="0">
                                                <Card.Body>
                                                    <div>
                                                        {data.map((person, index) => (
                                                            <p key={index}>{person.name} with {person.email}</p>
                                                        ))}
                                                    </div>
                                                </Card.Body>
                                            </Accordion.Collapse>
                                        </Card>
                                    </Accordion>
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col md="4">
                        <div class="flip-card">
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <p>-</p>
                                    <h2>Aspirants placed in 2021</h2>
                                </div>
                                <div class="flip-card-back">
                                    <p>-</p>
                                    <h2>652</h2>
                                </div>
                            </div>
                        </div>
                        <div class="flip-card">
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <p>-</p>
                                    <h2>Aspirants registered with us for 2021</h2>
                                </div>
                                <div class="flip-card-back">
                                    <p>-</p>
                                    <h2>700</h2>
                                </div>
                            </div>
                        </div>
                        <div class="flip-card">
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <p>-</p>
                                    <h2>Aspirants placed abroad</h2>
                                </div>
                                <div class="flip-card-back">
                                    <p>-</p>
                                    <h2>210</h2>
                                </div>
                            </div>
                        </div>
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

export default Home