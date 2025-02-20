/* This is a basic implementation of a store, which is basically a global data file
*
*
*
*
*
*
* Data in react only flows one way, but we can make a store to make data global
* Any data that you want to use throughout the app can reside here
* (We'll see a more encapsulated way in P2 with context API)
*
* For now we'll just have an object that has fields for the data we want to store
*
*/

export const store = {

    //For now, let's store info of the logged-in user (filled after successful login)
    loggedInUser: {
        userId: 0,
        username: "",
        role: "",
    }
    //NOT BEST PRACTICE -- this is a massive security vulnerability & the data will be wiped if you refresh browser
    //this is just good enough for P1
    //look into context API and local storage for a more modern take on this store


}