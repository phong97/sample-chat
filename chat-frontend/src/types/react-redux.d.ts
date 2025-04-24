import { ComponentType, PropsWithChildren } from 'react';
import { AnyAction, Store } from '@reduxjs/toolkit';

declare module 'react-redux' {
  // Overriding the Provider type to make it compatible with React 18
  export interface ProviderProps<A extends AnyAction = AnyAction> {
    store: Store<any, A>;
    context?: React.Context<Store<any, A>>;
    children: React.ReactNode;
  }

  export const Provider: ComponentType<PropsWithChildren<ProviderProps>>;
}