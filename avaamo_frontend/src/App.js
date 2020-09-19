import React, {Component} from 'react';
import {BrowserRouter} from "react-router-dom";
import {createBrowserHistory} from "history";
import RoutesContainer from "./RoutesContainer";

class App extends Component {
    render() {
        return (
            <BrowserRouter history={createBrowserHistory()} basename="">
                <RoutesContainer baseRoute=""/>
            </BrowserRouter>
        );
    }
}

export default App;
