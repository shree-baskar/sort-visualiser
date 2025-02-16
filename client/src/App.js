import React, { useState } from "react";
import SortingVisualiser from "./SortingVisualiser";
import './App.css';

const App = () => {
  const [steps, setSteps] = useState([]);
  const [input, setInput] = useState('');
  const [algorithm, setAlgorithm] = useState('bubblesort');

  const handleInputChange = (event) => {
    setInput(event.target.value);
  };

  const handleAlgorithmChange = (event) => {
    setAlgorithm(event.target.value);
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    setSteps([]);
    const array = input.split(',').map(num => parseInt(num.trim(), 10));

    try {
      const response = await fetch(`http://localhost:8080/api/${algorithm}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(array)
      });

      if (response.ok) {
        const steps = await response.json();
        setSteps(steps);
      } else {
        console.error('Error!');
      }
    } catch (error) {
      console.error('Error while sorting:', error);
    }
  };

  return (
    <div className="app-wrapper">
      <div className="container">
        <h1 className="title">Sorting Algorithm Visualiser</h1>
        <form onSubmit={handleFormSubmit} className="form">
          <div className="form-group">
            <label>Numbers (comma-separated):</label>
            <input
              type="text"
              value={input}
              onChange={handleInputChange}
              placeholder="5, 2, 9, 1, 5"
              className="input"
            />
          </div>
          <div className="form-group">
            <label>Algorithm:</label>
            <select value={algorithm} onChange={handleAlgorithmChange} className="select">
              <option value="bubblesort">Bubble Sort</option>
              <option value="insertionsort">Insertion Sort</option>
              <option value="selectionsort">Selection Sort</option>
              <option value="mergesort">Merge Sort</option>
              <option value="mo3quicksort">Median of Three Quick Sort</option>
              <option value="naivequicksort">Naive Quick Sort</option>
              <option value="randomquicksort">Randomised Quick Sort</option>
            </select>
          </div>
          <button type="submit" className="button">Sort</button>
        </form>
      </div>
      <SortingVisualiser steps={steps} />
    </div>
  );
};

export default App;
