const http = require("http");

const requestListener = (req, res) => {
  console.log(req,{depth :0});
  res.write("Hello Yo!!\n");
  res.end();
  // res.end("Hello Node\n");
};

const server = http.createServer();
server.on("request",requestListener );

server.listen(4242, () => {
  console.log("Server is running...");
});
