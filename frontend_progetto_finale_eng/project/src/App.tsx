import React, { useState } from 'react';
import { Navbar } from './components/Navbar';
import { LoginForm } from './components/LoginForm';
import { BookList } from './components/BookList';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar isLoggedIn={isLoggedIn} onLogout={handleLogout} />
      {isLoggedIn ? <BookList /> : <LoginForm onLogin={handleLogin} />}
    </div>
  );
}

export default App;