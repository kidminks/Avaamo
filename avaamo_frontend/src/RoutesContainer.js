import React from "react";
import {Switch, Route, Redirect} from "react-router-dom";
import {TopicsPage} from "./components/TopicsPage";
import {TopicPage} from "./components/TopicPage";

const RoutesContainer = props => {
	return (
		<Switch>
			<Route
				exact
				path={`${props.baseRoute}/topics`}
				component={selfProps => (
					<TopicsPage {...selfProps} baseRoute={props.baseRoute} />
				)}
			/>
			<Route
				exact
				path={`${props.baseRoute}/topics/:id`}
				component={selfProps => (
					<TopicPage {...selfProps} baseRoute={props.baseRoute} />
				)}
			/>
			<Redirect to="/topics"/>
		</Switch>
	)
}

export default RoutesContainer;