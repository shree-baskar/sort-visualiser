import React, { useState, useEffect, useRef } from 'react';
import Plot from 'react-plotly.js';

const SortingVisualiser = ({ steps }) => {
  const [currentStep, setCurrentStep] = useState(0);
  const [graphSize, setGraphSize] = useState({ width: 770, height: 533 });
  const containerRef = useRef(null);

  useEffect(() => {
    if (steps.length > 0) {
      const interval = setInterval(() => {
        setCurrentStep((prevStep) => {
          if (prevStep + 1 < steps.length) {
            return prevStep + 1;
          } else {
            clearInterval(interval);
            return prevStep;
          }
        });
      }, 200);

      return () => {
        setCurrentStep(0);
        clearInterval(interval);
      };
    }
  }, [steps]);

  useEffect(() => {
    const updateSize = () => {
      if (containerRef.current) {
        const containerWidth = containerRef.current.clientWidth * 0.9;
        const aspectRatio = 533 / 770;
        setGraphSize({ width: containerWidth, height: containerWidth * aspectRatio });
      }
    };

    window.addEventListener("resize", updateSize);
    updateSize();

    return () => window.removeEventListener("resize", updateSize);
  }, []);

  const data = {
    type: 'bar',
    x: Array.from({ length: steps[0]?.length }, (_, i) => `${i}`),
    y: steps[currentStep],
    marker: { color: 'rgba(75, 192, 192, 0.7)' },
    hoverinfo: "y",
  };

  const layout = {
    title: 'Bubble Sort Visualization',
    xaxis: { visible: false },
    yaxis: { visible: false },
    margin: { l: 0, r: 0, t: 0, b: 20 },
    showlegend: false,
    height: graphSize.height,
    width: graphSize.width,
    plot_bgcolor: 'rgba(0, 0, 0, 0)',
    paper_bgcolor: 'rgba(0, 0, 0, 0)',
    bargap: 0.07,
  };

  return (
    <div ref={containerRef} className="sorting-visualiser">
      <Plot
        data={[data]}
        layout={layout}
        config={{
          staticPlot: true,
          displayModeBar: false,
          responsive: true,
        }}
      />
    </div>
  );
};

export default SortingVisualiser;
