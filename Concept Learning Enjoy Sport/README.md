# Learns the concept "EnjoySport" using Find-S and Candidate-Elimination Algorithms

Target concept is <sunny, warm, ?, ?, ?, ?>

## Example Find-S Training Process printed by the program:

training example: <cloudy,cool,high,strong,cool,change><br> false<br>
hypothesis: <Ø,Ø,Ø,Ø,Ø,Ø><br>
training example: <sunny,warm,normal,strong,warm,same><br> true<br>
hypothesis: <sunny,warm,normal,strong,warm,same><br>
training example: <sunny,warm,high,weak,warm,same><br> true<br>
hypothesis: <sunny,warm,?,?,warm,same><br>
training example: <cloudy,cool,high,strong,cool,same><br> false<br>
hypothesis: <sunny,warm,?,?,warm,same><br>
training example: <rainy,cool,high,weak,warm,change><br> false<br>
hypothesis: <sunny,warm,?,?,warm,same><br>
training example: <rainy,warm,normal,strong,cool,change><br> false<br>
hypothesis: <sunny,warm,?,?,warm,same><br>
training example: <rainy,warm,high,weak,cool,change><br> false<br>
hypothesis: <sunny,warm,?,?,warm,same><br>
training example: <cloudy,cool,normal,weak,warm,change><br> false<br>
hypothesis: <sunny,warm,?,?,warm,same><br>
training example: <sunny,warm,normal,weak,warm,change><br> true<br>
hypothesis: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,warm,high,strong,cool,same><br> false<br>
hypothesis: <sunny,warm,?,?,warm,?><br>
training example: <sunny,warm,normal,weak,cool,change><br> true<br>
hypothesis: <sunny,warm,?,?,?,?><br>

## Example Candidate-Elimination Training Process printed by the program:

training example: <rainy,cool,normal,weak,warm,same><br> false<br>
hypothesis G: <sunny,?,?,?,?,?><br>
hypothesis G: <cloudy,?,?,?,?,?><br>
hypothesis G: <?,warm,?,?,?,?><br>
hypothesis G: <?,?,high,?,?,?><br>
hypothesis G: <?,?,?,strong,?,?><br>
hypothesis G: <?,?,?,?,cool,?><br>
hypothesis G: <?,?,?,?,?,change><br>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø><br>
training example: <rainy,warm,normal,strong,cool,change><br> false<br>
hypothesis G: <sunny,?,?,?,?,?><br>
hypothesis G: <cloudy,?,?,?,?,?><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <?,warm,?,?,?,same><br>
hypothesis G: <?,?,high,?,?,?><br>
hypothesis G: <?,cool,?,strong,?,?><br>
hypothesis G: <?,?,?,strong,warm,?><br>
hypothesis G: <?,?,?,strong,?,same><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,weak,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis G: <?,cool,?,?,?,change><br>
hypothesis G: <?,?,?,weak,?,change><br>
hypothesis G: <?,?,?,?,warm,change><br>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø><br>
training example: <sunny,cool,normal,weak,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,strong,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,?><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <?,warm,?,?,?,same><br>
hypothesis G: <?,?,high,?,?,?><br>
hypothesis G: <?,cool,?,strong,?,?><br>
hypothesis G: <?,?,?,strong,warm,?><br>
hypothesis G: <?,?,?,strong,?,same><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,weak,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis G: <?,cool,?,?,?,change><br>
hypothesis G: <?,?,?,weak,?,change><br>
hypothesis G: <?,?,?,?,warm,change><br>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø><br>
training example: <cloudy,cool,normal,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,strong,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,warm,?,?,?,?><br>
hypothesis G: <cloudy,?,?,strong,?,?><br>
hypothesis G: <cloudy,?,?,?,cool,?><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <?,warm,?,?,?,same><br>
hypothesis G: <?,?,high,?,?,?><br>
hypothesis G: <?,cool,?,strong,?,?><br>
hypothesis G: <?,?,?,strong,warm,?><br>
hypothesis G: <?,?,?,strong,?,same><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,weak,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis G: <rainy,cool,?,?,?,change><br>
hypothesis G: <rainy,?,?,weak,?,change><br>
hypothesis G: <rainy,?,?,?,warm,change><br>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø><br>
training example: <sunny,warm,high,weak,warm,change><br> true<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,strong,?,?><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <?,?,high,?,?,?><br>
hypothesis G: <?,?,?,strong,warm,?><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis G: <rainy,?,?,weak,?,change><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,cool,normal,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <?,?,high,?,?,?><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis G: <rainy,?,?,weak,?,change><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,cool,high,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis G: <?,warm,high,?,?,?><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,cool,normal,weak,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis G: <?,warm,high,?,?,?><br>
hypothesis G: <?,cool,?,?,cool,?><br>
hypothesis G: <?,?,?,?,cool,same><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,cool,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis G: <?,warm,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,cool,high,strong,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <?,warm,?,?,warm,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis G: <?,warm,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,high,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,warm,normal,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <cloudy,?,?,?,?,same><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,cool,normal,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,warm,high,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,warm,normal,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,cool,high,strong,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,cool,normal,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <?,warm,?,weak,?,?><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,normal,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <sunny,?,?,?,?,change><br>
hypothesis G: <?,warm,high,weak,?,?><br>
hypothesis G: <?,warm,?,weak,warm,?><br>
hypothesis G: <?,warm,?,weak,?,change><br>
hypothesis G: <sunny,?,high,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,cool,high,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis G: <?,warm,high,weak,?,?><br>
hypothesis G: <?,warm,?,weak,warm,?><br>
hypothesis G: <?,warm,?,weak,?,change><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,high,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis G: <sunny,?,?,?,cool,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,cool,high,strong,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,high,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,high,weak,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,cool,high,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,cool,normal,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,normal,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,warm,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,cool,high,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <rainy,cool,normal,weak,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,cool,normal,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,warm,normal,weak,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <cloudy,cool,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,cool,high,strong,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,high,weak,warm,change><br>
training example: <sunny,warm,normal,strong,warm,same><br> true<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,warm,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <sunny,cool,normal,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,warm,high,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <sunny,warm,normal,strong,warm,change><br> true<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,warm,high,strong,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,warm,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,normal,weak,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,cool,high,weak,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,cool,high,weak,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,cool,high,strong,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,normal,strong,warm,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <sunny,cool,high,strong,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <sunny,warm,high,weak,warm,change><br> true<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,normal,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,high,weak,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <cloudy,cool,normal,strong,cool,change><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,high,strong,cool,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <rainy,cool,normal,strong,warm,same><br> false<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,warm,?><br>
training example: <sunny,warm,normal,strong,cool,change><br> true<br>
hypothesis G: <sunny,warm,?,?,?,?><br>
hypothesis S: <sunny,warm,?,?,?,?><br>
