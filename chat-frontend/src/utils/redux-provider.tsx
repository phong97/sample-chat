import React from 'react';
import { Provider as ReduxProvider } from 'react-redux';
import { Store } from '@reduxjs/toolkit';

interface CustomProviderProps {
  store: Store;
  children: React.ReactNode;
}

// This component wraps the Redux Provider to fix TypeScript compatibility issues
export const ReduxStoreProvider: React.FC<CustomProviderProps> = ({ store, children }) => {
  return (
    // @ts-ignore - Ignoring the TypeScript error for the Redux Provider
    <ReduxProvider store={store}>
      {children}
    </ReduxProvider>
  );
};