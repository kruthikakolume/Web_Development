import React from 'react'
import Card from 'react-bootstrap/Card'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Col } from 'react-bootstrap';
import { Link } from 'react-router-dom'
import img1 from '../../images/cover.jpeg';
import './About.css';

const About = () => {
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
            <div sclass="init">
                <div class="container">
                    <Container>
                        <Col md="12">
                            <h3>Who are we?</h3>
                            <Card>
                                <Card.Body>
                                    <Card.Text>
                                    <br /><br />
                                        Aspirants scrapes thousands of jobs from company career pages. top job boards, classfieds. Some employers also post openings here directly.
                                        <br /><br />
                                        Our mission is to create products that provide opportunities for all job seekers. To do this, we hire Indeedians of all backgrounds to mirror the job seekers we support. That's why Inclusion and Belonging are core values inside Aspirant.
                                        <br /><br />
                                        First, we deliver great job listings. Second, we bootstrap your networking outreach. Human resources love it to source qualified candidates. Users can set up a free account, post rich profiles and connect with key industry power players with one click.
                                        <br /><br />
                                        Aspirant is an American worldwide employment website for job listings launched in November 2004. It is an independent subsidiary of multinational holding Recruit Co. Ltd. It is co-headquartered in Austin, Texas, and Stamford, Connecticut, with additional offices around the world. As a single-topic search engine, it is also an example of vertical search. Aspirat is currently available in over 60 countries and 28 languages. In October 2010, Aspirant.com passed Monster.com to become the highest-traffic job website in the United States.
                                        <br /><br />
                                        The site aggregates job listings from thousands of websites, including job boards, staffing firms, associations, and company career pages. They generate revenue by selling premium job posting and resume features to employers and companies hiring. In 2011, Aspirant began allowing job seekers to apply directly to jobs on Aspirant's site and offering resume posting and storage.
                                    </Card.Text>
                                </Card.Body>
                            </Card>
                        </Col>
                    </Container>
                </div>
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

export default About