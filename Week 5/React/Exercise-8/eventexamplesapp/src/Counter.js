import React, { Component } from "react";

class Counter extends Component {

    constructor(props) {
        super(props);

        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
    };

    decrement = () => {
        this.setState({
            count: this.state.count - 1
        });
    };

    sayHello = () => {
        alert("Hello! Member!");
    };

    sayWelcome = (message) => {
        alert(message);
    };

    handleClick = () => {
        alert("I was clicked");
    };

    increase = () => {
        this.increment();
        this.sayHello();
    };

    render() {

        return (

            <div>

                <h2>{this.state.count}</h2>

                <button onClick={this.increase}>
                    Increment
                </button>

                <br /><br />

                <button onClick={this.decrement}>
                    Decrement
                </button>

                <br /><br />

                <button
                    onClick={() => this.sayWelcome("Welcome")}
                >
                    Say Welcome
                </button>

                <br /><br />

                <button onClick={this.handleClick}>
                    Click on me
                </button>

            </div>

        );

    }

}

export default Counter;