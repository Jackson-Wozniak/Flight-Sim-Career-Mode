import './styles/App.css';
import HomePage from './components/HomePage';
import LoginPage from './components/LoginPage';
import PilotHomePage from './components/PilotHomePage'
import { Routes, Route } from 'react-router-dom';
import SignUpPage from './components/SignUpPage';
import LoadingScreen from './components/LoadingScreen';

function App() {

  return (
    <Routes>
      <Route path="" element={<HomePage />} />
      <Route path="loading" element={<LoadingScreen />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/sign-up" element={<SignUpPage />} />
      <Route path="pilot-home" element={<PilotHomePage />} />
    </Routes>
  );
}

export default App;
