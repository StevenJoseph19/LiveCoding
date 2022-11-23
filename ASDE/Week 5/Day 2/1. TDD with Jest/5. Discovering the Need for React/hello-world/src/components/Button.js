import React,{Component} from 'react';
import './Button.css';

class Button extends Component {
    render() {
        // return ("");
        // return (<button className="location-button">Store</button>);
        return (<button className="location-button">{this.props.location ? this.props.location : "All Locations"}</button>);
    }
}

export default Button;