const trains = [
  { trainNo: 101, name: "Express 1", source: "Hyderabad", destination: "Delhi", time: "06:00" },
  { trainNo: 102, name: "Superfast", source: "Chennai", destination: "Mumbai", time: "08:30" },
  { trainNo: 103, name: "Intercity", source: "Delhi", destination: "Agra", time: "10:00" },
  { trainNo: 104, name: "Local", source: "Hyderabad", destination: "Warangal", time: "12:00" }
];

const bookings = [];

function displayTrains(list = trains) {
  const trainList = document.getElementById("trainList");
  trainList.innerHTML = "";
  if (list.length === 0) {
    trainList.innerHTML = "<p>No trains found.</p>";
    return;
  }

  list.forEach(train => {
    const div = document.createElement("div");
    div.className = "train";
    div.innerHTML = `<strong>${train.trainNo}</strong> - ${train.name} | From: ${train.source} | To: ${train.destination} | Time: ${train.time}`;
    trainList.appendChild(div);
  });
}

function searchTrains() {
  const source = document.getElementById("source").value.trim().toLowerCase();
  const destination = document.getElementById("destination").value.trim().toLowerCase();

  const results = trains.filter(train =>
    train.source.toLowerCase() === source &&
    train.destination.toLowerCase() === destination
  );

  displayTrains(results);
}

function bookTicket() {
  const name = document.getElementById("passengerName").value.trim();
  const trainNo = parseInt(document.getElementById("trainNo").value);

  const train = trains.find(t => t.trainNo === trainNo);

  if (!name || isNaN(trainNo) || !train) {
    alert("Invalid details! Check name or train number.");
    return;
  }

  bookings.push({ name, trainNo });
  alert("Ticket booked successfully!");
  displayBookings();
}

function displayBookings() {
  const bookingList = document.getElementById("bookingList");
  bookingList.innerHTML = "";

  if (bookings.length === 0) {
    bookingList.innerHTML = "<p>No bookings yet.</p>";
    return;
  }

  bookings.forEach(b => {
    const div = document.createElement("div");
    div.className = "booking";
    div.innerHTML = `Passenger: ${b.name} | Train No: ${b.trainNo}`;
    bookingList.appendChild(div);
  });
}

// Load all trains initially
displayTrains();
