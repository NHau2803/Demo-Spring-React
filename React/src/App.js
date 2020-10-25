import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import ListEmployee from './components/ListEmployee';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateEmployee from './components/CreateEmployee';
import UpdateEmployee from './components/UpdateEmployee';
import ViewEmployee from './components/ViewEmployee';

function App() {
    return ( 
        <div>
        <Router>
            <HeaderComponent />
            <div className = "container">
                <Switch>
                    <Route path='/' exact component={ListEmployee}></Route>
                    <Route path='/employees' component={ListEmployee}></Route>
                    <Route path='/add-employee/:id' component={CreateEmployee}></Route> 
                    <Route path='/view-employee/:id' component={ViewEmployee}></Route>
                    {/* <Route path='/add-employee' component={CreateEmployee}></Route> */}
                    {/* <Route path='/update-employee/:id' component={UpdateEmployee}></Route> */}
                    <ListEmployee />
                </Switch>
            </div>
            <FooterComponent />
        </Router> 
        </div>
    );
}

export default App;