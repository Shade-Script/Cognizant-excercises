import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
    return (
        <div>
            <CalculateScore
                Name="Aditya Yadav"
                School="VIT Bhopal"
                Total={450}
                goal={5}
            />
        </div>
    );
}

export default App;