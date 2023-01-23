import './styles/App.css';
import HomePage from './components/HomePage';
import LoginPage from './components/LoginPage';
import PilotHomePage from './components/PilotHomePage'
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="pilot-home" element={<PilotHomePage />}/>
    </Routes>
  );
}

export default App;
