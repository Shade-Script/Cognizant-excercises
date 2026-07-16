import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {
    const average = props.Total / props.goal;

    return (
        <div className="container">
            <h2>Student Score Calculator</h2>

            <p><strong>Name:</strong> {props.Name}</p>

            <p><strong>School:</strong> {props.School}</p>

            <p><strong>Total Marks:</strong> {props.Total}</p>

            <p><strong>Number of Subjects:</strong> {props.goal}</p>

            <h3>Average Score = {average}</h3>
        </div>
    );
}

export default CalculateScore;