import React, { useState } from "react";
import Input from "./components/Input";
import SortingVisualiser from "./components/SortingVisualiser";
import './App.css';

const App = () => {
  const [steps, setSteps] = useState([]);

  return (
    <div className="app-wrapper">
      <Input setSteps={setSteps} />
      <SortingVisualiser steps={steps} />
    </div>
  );
};

export default App;
