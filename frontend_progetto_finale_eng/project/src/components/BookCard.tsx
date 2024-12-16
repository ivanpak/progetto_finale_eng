import React from 'react';
import { Book, BookOwnership } from '../types';
import { BookOpen, CheckCircle, XCircle, Calendar } from 'lucide-react';
import { isBookAvailable, formatDate } from '../utils/bookUtils';

interface BookCardProps {
  book: Book;
  ownerships: BookOwnership[];
  onBorrow: (bookId: number) => Promise<void>;
  onReturn: (bookId: number) => Promise<void>;
}

export function BookCard({ book, ownerships, onBorrow, onReturn }: BookCardProps) {
  const available = isBookAvailable(ownerships);
  const currentOwnership = ownerships?.find(o => o.data_di_fine === null);

  return (
    <div className="bg-white rounded-lg shadow-md p-6">
      <div className="flex items-center mb-4">
        <BookOpen className="h-6 w-6 text-indigo-600 mr-2" />
        <h3 className="text-xl font-semibold text-gray-800">{book.nome}</h3>
      </div>
      <div className="space-y-2 mb-4">
        <p className="text-gray-600">Author: {book.autore}</p>
        {book.isbn && <p className="text-gray-600">ISBN: {book.isbn}</p>}
        {currentOwnership && (
          <div className="flex items-center text-gray-600">
            <Calendar className="h-4 w-4 mr-2" />
            <span>Borrowed: {formatDate(currentOwnership.data_di_inizio)}</span>
          </div>
        )}
      </div>
      <div className="flex items-center justify-between">
        <div className="flex items-center">
          {available ? (
            <CheckCircle className="h-5 w-5 text-green-500 mr-2" />
          ) : (
            <XCircle className="h-5 w-5 text-red-500 mr-2" />
          )}
          <span className={available ? 'text-green-500' : 'text-red-500'}>
            {available ? 'Available' : 'Borrowed'}
          </span>
        </div>
        {available ? (
          <button
            onClick={() => onBorrow(book.id)}
            className="bg-indigo-600 text-white px-4 py-2 rounded hover:bg-indigo-700 transition-colors"
          >
            Borrow
          </button>
        ) : (
          <button
            onClick={() => onReturn(book.id)}
            className="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700 transition-colors"
          >
            Return
          </button>
        )}
      </div>
    </div>
  );
}