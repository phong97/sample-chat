import axios from 'axios';

interface SendMessageParams {
  sender: string;
  content: string;
}

export interface Message {
  id: number;
  sender: string;
  content: string;
  timestamp: string;
}

const API_BASE_URL = 'http://localhost:8080/api';

export const fetchMessageHistory = async (): Promise<Message[]> => {
  try {
    const response = await axios.get(`${API_BASE_URL}/history`);
    return response.data;
  } catch (error) {
    console.error('Error fetching message history:', error);
    return [];
  }
};

export const sendMessage = async ({ sender, content }: SendMessageParams): Promise<void> => {
  try {
    await axios.post(`${API_BASE_URL}/send`, null, {
      params: {
        sender,
        content
      }
    });
  } catch (error) {
    console.error('Error sending message:', error);
    throw error;
  }
};