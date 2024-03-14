import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [texts, setTexts] = useState(['', '']);
  const [mergedText, setMergedText] = useState('');
  const [savedTexts, setSavedTexts] = useState([]);
  const [elapsedTime, setElapsedTime] = useState('');
  const [data, setData] = useState([]);

  const handleTextChange = (event, index) => {
    const newValues = [...texts];
    newValues[index] = event.target.value;
    setTexts(newValues);
  };

  const addText = () => {
    setTexts([...texts, '']);
  };

  const getFromDatabase = () => {
    fetch('http://localhost:8080/api/all')
      .then(response => response.json())
      .then(data => setTexts(data));
  }


  const mergeTexts = () => {
    axios.post('http://localhost:8080/api/cumle', texts)
      .then(response => {
        setMergedText(response.data.text);
        setElapsedTime(response.data.elapsedTime);
      })
      .catch(error => console.log(error));
  };


  const saveTexts = () => {
    axios
      .post('http://localhost:8080/api/add', texts)
      .then(response => setSavedTexts([...savedTexts, response.data]))
      .catch(error => console.log(error));
  };

  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: '50px' }}>
      <h1 style={{ marginBottom: '50px', fontSize: '36px', fontWeight: 'bold' }}>Yazılım Laboratuvarı II - I.Proje</h1>
      {texts.map((text, index) => (
        <div key={index} style={{ display: "flex", flexDirection: "row", alignItems: "center", justifyContent: "center", marginBottom: "20px" }}>
          <label style={{ textAlign: "center", width: "25%", fontSize: '24px', fontWeight: 'bold' }}>Text {index + 1}:</label>
          <textarea
            value={text}
            onChange={event => handleTextChange(event, index)}
            style={{ width: "800px", height: "35px", fontSize: '18px', padding: '10px' }}
          />
        </div>
      ))}
      <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', marginTop: '30px' }}>
        <div className='buttons' style={{alignItems:"center"}}>
          <button style={{ margin:"15px", fontSize: '18px', fontWeight: 'bold', padding: '10px 20px', borderRadius: '10px', backgroundColor: '#009688', color: 'white', cursor: 'pointer' }} onClick={addText}>Text Ekle</button>
          <button style={{ margin:"15px", fontSize: '18px', fontWeight: 'bold', padding: '10px 20px', borderRadius: '10px', backgroundColor: '#4CAF50', color: 'white', cursor: 'pointer' }} onClick={mergeTexts}>Textleri Birleştir</button>
          <button style={{ margin:"15px",fontSize: '18px', fontWeight: 'bold', padding: '10px 20px', borderRadius: '10px', backgroundColor: '#2196F3', color: 'white', cursor: 'pointer' }} onClick={saveTexts}>Textleri Kaydet</button>

        </div>

        <div className="button-container mb-4">
          <button style={{margin:"15px", marginTop:"25px", fontSize: '18px', fontWeight: 'bold', padding: '10px 20px', borderRadius: '10px', backgroundColor: '#009688', color: 'white', cursor: 'pointer' }} onClick={getFromDatabase}>Databasedeki verileri getir</button>
        </div>

      </div>

      {mergedText && (
        <div style={{ marginTop: "20px", width: "800px", textAlign: "center" }}>
          <textarea value={`Düzenlenmiş metin: ${mergedText}`} readOnly style={{ textAlign: "center", width: "100%", height: "50px", fontSize: '18px', padding: '10px' }} />
        </div>
      )}
      {savedTexts.map((text, index) => (
        <div key={index} style={{ marginTop: '30px', fontSize: '24px', fontWeight: 'bold' }}>{JSON.stringify(text)}</div>
      ))}
      {elapsedTime && (
        <div style={{ marginTop: "20px", width: "800px", textAlign: "center" }}>
          <textarea value={`Geçen süre: ${elapsedTime} ns`} readOnly style={{ width: "100%", height: "50px", fontSize: '18px', padding: '10px', textAlign: "center" }} />
        </div>
      )}

      <div className="container">
        <h1 className="text-center mb-4">Databasedeki Veri Listesi</h1>

        <div className="card-container d-flex flex-wrap">
          {texts.map(text => (
            <div key={text._id} className="card col-lg-4 col-md-6 col-sm-12 mb-4">
              <div className="card-body rounded-lg" style={{ background: "linear-gradient(to bottom right, #f5f7fa, #c3cfe2)", marginTop: "30px", paddingTop: "10px", paddingLeft: "25px", paddingRight: "25px" }}>

                {text.text && text.text.map((paragraph, index) => (
                  <p key={index} className="card-text" style={{}}>{paragraph}</p>
                ))}
                <hr className="separator" />

                <div className="time-container">
                  <p><strong> Geçen Süre: {text.elapsedTime} ns</strong></p>
                </div>
                <hr className="separator" />

                <h5 className="card-title">{text.conclusion}</h5>

                <hr className="separator" />
              </div>
            </div>
          ))}
        </div>
      </div>

    </div>

  );
}

export default App;