import React from 'react';
import Card from 'react-bootstrap/Card'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Col, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom'
import img1 from '../../images/cover.jpeg';
import './Jobs.css';

function Jobs() {
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
                    <Col md="4">
                    <h3></h3>
                        <Card>
                            <Card.Body>
                                <Card.Title>iVueit App</Card.Title>
                                <Card.Text>
                                    Take photos and make $$$- Get up to $100 Daily with the iVueit App!
                                    <br /><br />
                                    Make Money Taking Photos
                                    <br />
                                    With iVueit, you get paid real money every time you successfully complete a Vue. Once your job is approved you'll be paid in 24 hours or less.
                                    <br /><br />
                                    Work When You Want
                                    <br />
                                    Claim and complete Vues when it is convenient for you, we have daytime and nighttime Vues.
                                    <br />
                                    All you need is a smartphone
                                    <br />
                                    This is the only equipment you will need! Download the iVueit app and start claiming Vues near you.
                                    <br />
                                    Get Paid Fast
                                    <br />
                                    Your iVueit Wallet is credited every time your Vues are approved. Simply select withdraw in the wallet and funds are transferred to your PayPal account within 24 hours.<br /><br />
                                    Salary:
                                    $15 - $100 an hour
                                    <br /><br />
                                    Job Type:
                                    Part-time
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col md="4">
                    <h3></h3>
                        <Card>
                            <Card.Body>
                                <Card.Title>Instacart Shoppers</Card.Title>
                                <Card.Text>
                                    Shop and Deliver - No Experience Required
                                    <br /><br />
                                    Job description<br />
                                    FULL-SERVICE SHOPPER
                                    <br />
                                    Start earning money fast and be your own boss. Become an Instacart Shopper.
                                    <br />
                                    Instacart is a leading retail enablement platform that works with grocers and retailers to transform how people shop. Instacart’s platform helps people get groceries, home essentials, and more from their favorite local stores.
                                    <br />
                                    Shoppers deliver convenience and excellent service to people in their neighborhood.
                                    <br />
                                    Set your own schedule, choose the areas where you want to shop, and earn money towards your financial goals. There’s never been a better time to become a shopper—sign up today.<br /><br />
                                    Benefits of working with Instacart:<br />
                                    Start earning quickly* on your own schedule<br />
                                    Paid weekly, with the option of cashing out in minutes<br />
                                    Potential to earn tips for good service<br />
                                    Special earnings promotions
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col md="4">
                    <h3></h3>
                        <Card>
                            <Card.Body>
                                <Card.Title>SudShare</Card.Title>
                                <Card.Text>
                                    Laundry Worker
                                    <br /><br />
                                    Job description<br />
                                    Work from Home doing Laundry and Earn $20-$30/Hour<br /><br />

                                    Be Your Own Boss<br />
                                    Work When You Want<br />
                                    Work from Home<br />
                                    Instant Payouts Available<br />
                                    Start Immediately<br /><br />
                                    How it works<br />
                                    1. Sign-up (Simply fill out a form.)<br />
                                    2. Accept Jobs (We send you jobs in your area. Accept the jobs you want.)<br />
                                    3. Wash-Dry-Fold (Pick up your customers laundry, wash-dry-fold, and deliver.)<br />
                                    4. Get Paid (Direct deposit weekly. Instant payout available for advanced badges.)<br /><br />
                                    Job Types: Full-time, Part-time<br />
                                    Pay: $15.00 - $20.00 per hour<br />

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

export default Jobs