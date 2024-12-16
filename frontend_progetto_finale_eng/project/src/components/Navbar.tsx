import React from 'react';
import { BookOpen, LogOut } from 'lucide-react';
import { api } from '../api';

interface NavbarProps {
  isLoggedIn: boolean;
  onLogout: () => void;
}

export function Navbar({ isLoggedIn, onLogout }: NavbarProps) {
  const handleLogout = async () => {
    await api.logout();
    onLogout();
  };

  return (
    <nav className="bg-indigo-600 text-white p-4">
      <div className="container mx-auto flex justify-between items-center">
        <div className="flex items-center space-x-2">
          <BookOpen className="h-6 w-6" />
          <span className="text-xl font-bold">Library Manager</span>
        </div>
        {isLoggedIn && (
          <button
            onClick={handleLogout}
            className="flex items-center space-x-2 hover:text-indigo-200"
          >
            <LogOut className="h-5 w-5" />
            <span>Logout</span>
          </button>
        )}
      </div>
    </nav>
  );
}