import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 82 },
        { name: "Shubman Gill", score: 68 },
        { name: "KL Rahul", score: 76 },
        { name: "Hardik Pandya", score: 61 },
        { name: "Ravindra Jadeja", score: 88 },
        { name: "R Ashwin", score: 58 },
        { name: "Mohammed Shami", score: 47 },
        { name: "Jasprit Bumrah", score: 72 },
        { name: "Kuldeep Yadav", score: 66 },
        { name: "Mohammed Siraj", score: 74 }
    ];

    const lowScorers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <h3>All Players</h3>

            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

            <h3>Players with Score Below 70</h3>

            <ul>
                {lowScorers.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default ListofPlayers;