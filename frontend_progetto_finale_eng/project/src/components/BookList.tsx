import React from 'react';
import { api } from '../api';
import { BookCard } from './BookCard';
import { LoadingSpinner } from './LoadingSpinner';
import { ErrorMessage } from './ErrorMessage';
import { useBooks } from '../hooks/useBooks';

export function BookList() {
  const { books, ownerships, loading, error, refreshBooks } = useBooks();

  const handleBorrow = async (bookId: number) => {
    try {
      await api.borrowBook(bookId);
      await refreshBooks();
    } catch (error) {
      console.error('Error borrowing book:', error);
    }
  };

  const handleReturn = async (bookId: number) => {
    try {
      await api.returnBook(bookId);
      await refreshBooks();
    } catch (error) {
      console.error('Error returning book:', error);
    }
  };

  if (loading) return <LoadingSpinner />;
  if (error) return <ErrorMessage message={error} />;

  return (
    <div className="container mx-auto px-4 py-8">
      <h2 className="text-2xl font-bold mb-6 text-gray-800">Library Books</h2>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {books.map((book) => (
          <BookCard
            key={book.id}
            book={book}
            ownerships={ownerships[book.id] || []}
            onBorrow={handleBorrow}
            onReturn={handleReturn}
          />
        ))}
      </div>
    </div>
  );
}