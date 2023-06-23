// function fetchEmployeeDetails() {
//     var employeeId = document.getElementById("employeeId").value;
//     var url = "http://localhost:8888/employeeController/emp/" + employeeId;
  
//     // Send a GET request to the API
//     fetch(url)
//       .then(function(response) {
//         return response.json();
//       })
//       .then(function(data) {
//         displayEmployeeDetails(data);
//       })
//       .catch(function(error) {
//         console.log("Error:", error);
//       });
//   }

  
  document.getElementById("searchButton").addEventListener("click", function() {
    let employeeId = document.getElementById("employeeId").value;
    
    if (employeeId) { // Check if the employeeId value is not empty or undefined
      fetchEmployeeDetails(parseInt(employeeId)); // Convert the employeeId to an integer and pass it to the function
    } else {
      console.log("Please enter a valid employee ID.");
    }
    
  });
  

  let fetchEmployeeDetails = async (employeeId) => {
    try {
      const res = await fetch(`http://localhost:8888/employeeController/emp/${employeeId}`, {
        method: "GET", // Change the method to GET since you're retrieving data
        headers: {
          "Content-Type": "application/json",
        },
      });
  
      if (res.ok) {
        console.log("success");
        const data = await res.json();
        displayEmployeeDetails(data); // Call the displayEmployeeDetails function with the fetched data
      } else {
        const data = await res.json();
        const error = JSON.stringify(data);
        const msg = JSON.parse(error);
        console.log(msg);
        throw new Error(msg.message);
      }
    } catch (error) {
      console.log(error);
      throw new Error(error);
    }
  };
  

  
  function displayEmployeeDetails(details) {
    var employeeDetailsDiv = document.getElementById("employeeDetails");
    employeeDetailsDiv.innerHTML = "<pre>" + JSON.stringify(details, null, 2) + "</pre>";
  }
  