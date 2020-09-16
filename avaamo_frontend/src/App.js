import React, {Component} from 'react';
import {Router} from "react-router-dom";
import {createBrowserHistory} from "history";
import RoutesContainer from "./RoutesContainer";

class App extends Component {
    render() {
        return (
            <Router history={createBrowserHistory()} basename="">
                <RoutesContainer baseRoute=""/>
            </Router>
        );
    }
}

export default App;
