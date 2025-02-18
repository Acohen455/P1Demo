//Global interface to store and manage user data
//These fields are populated from the JSON response -- react extrapolates from that response how to populate these

export interface User {
    userId: number;
    username: string;
    role: string;
}