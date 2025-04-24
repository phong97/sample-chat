import * as React from 'react';
import { Helmet } from 'react-helmet-async';
import { ChatContainer } from './components/ChatContainer';

export function HomePage() {
  return (
    <>
      <Helmet>
        <title>Chat Application</title>
        <meta name="description" content="Interactive chat application" />
      </Helmet>
      <div className="h-[calc(100vh-180px)]">
        <ChatContainer />
      </div>
    </>
  );
}
