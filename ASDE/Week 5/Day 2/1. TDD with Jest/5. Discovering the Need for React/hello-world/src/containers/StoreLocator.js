import React, {Component} from 'react';
import Header from '../components/Header';
import Button from '../components/Button';
import Map from '../components/Map';

class StoreLocator extends Component {
    render() {
        // return (" ");
        // return (<div>
        return  (
                    <div>
                        <Header />
                        <Button location="Portland"/> <Button location="Astoria"/>
                        <Button />
                    <Map />
               </div>
                );
    }
}

export default StoreLocator;