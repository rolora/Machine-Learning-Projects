#Learns the concept "EnjoySport" using Find-S and Candidate-Elimination Algorithms

##Example Find-S Training Process printed by the program:

training example: <cloudy,cool,high,strong,cool,change> false
hypothesis: <Ø,Ø,Ø,Ø,Ø,Ø>
training example: <sunny,warm,normal,strong,warm,same> true
hypothesis: <sunny,warm,normal,strong,warm,same>
training example: <sunny,warm,high,weak,warm,same> true
hypothesis: <sunny,warm,?,?,warm,same>
training example: <cloudy,cool,high,strong,cool,same> false
hypothesis: <sunny,warm,?,?,warm,same>
training example: <rainy,cool,high,weak,warm,change> false
hypothesis: <sunny,warm,?,?,warm,same>
training example: <rainy,warm,normal,strong,cool,change> false
hypothesis: <sunny,warm,?,?,warm,same>
training example: <rainy,warm,high,weak,cool,change> false
hypothesis: <sunny,warm,?,?,warm,same>
training example: <cloudy,cool,normal,weak,warm,change> false
hypothesis: <sunny,warm,?,?,warm,same>
training example: <sunny,warm,normal,weak,warm,change> true
hypothesis: <sunny,warm,?,?,warm,?>
training example: <cloudy,warm,high,strong,cool,same> false
hypothesis: <sunny,warm,?,?,warm,?>
training example: <sunny,warm,normal,weak,cool,change> true
hypothesis: <sunny,warm,?,?,?,?>

##Example Candidate-Elimination Training Process printed by the program:

training example: <rainy,cool,normal,weak,warm,same> false
hypothesis G: <sunny,?,?,?,?,?>
hypothesis G: <cloudy,?,?,?,?,?>
hypothesis G: <?,warm,?,?,?,?>
hypothesis G: <?,?,high,?,?,?>
hypothesis G: <?,?,?,strong,?,?>
hypothesis G: <?,?,?,?,cool,?>
hypothesis G: <?,?,?,?,?,change>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø>
training example: <rainy,warm,normal,strong,cool,change> false
hypothesis G: <sunny,?,?,?,?,?>
hypothesis G: <cloudy,?,?,?,?,?>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <?,warm,?,?,?,same>
hypothesis G: <?,?,high,?,?,?>
hypothesis G: <?,cool,?,strong,?,?>
hypothesis G: <?,?,?,strong,warm,?>
hypothesis G: <?,?,?,strong,?,same>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,weak,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis G: <?,cool,?,?,?,change>
hypothesis G: <?,?,?,weak,?,change>
hypothesis G: <?,?,?,?,warm,change>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø>
training example: <sunny,cool,normal,weak,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,strong,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,?>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <?,warm,?,?,?,same>
hypothesis G: <?,?,high,?,?,?>
hypothesis G: <?,cool,?,strong,?,?>
hypothesis G: <?,?,?,strong,warm,?>
hypothesis G: <?,?,?,strong,?,same>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,weak,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis G: <?,cool,?,?,?,change>
hypothesis G: <?,?,?,weak,?,change>
hypothesis G: <?,?,?,?,warm,change>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø>
training example: <cloudy,cool,normal,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,strong,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,warm,?,?,?,?>
hypothesis G: <cloudy,?,?,strong,?,?>
hypothesis G: <cloudy,?,?,?,cool,?>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <?,warm,?,?,?,same>
hypothesis G: <?,?,high,?,?,?>
hypothesis G: <?,cool,?,strong,?,?>
hypothesis G: <?,?,?,strong,warm,?>
hypothesis G: <?,?,?,strong,?,same>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,weak,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis G: <rainy,cool,?,?,?,change>
hypothesis G: <rainy,?,?,weak,?,change>
hypothesis G: <rainy,?,?,?,warm,change>
hypothesis S: <Ø,Ø,Ø,Ø,Ø,Ø>
training example: <sunny,warm,high,weak,warm,change> true
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,strong,?,?>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <?,?,high,?,?,?>
hypothesis G: <?,?,?,strong,warm,?>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis G: <rainy,?,?,weak,?,change>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,cool,normal,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <?,?,high,?,?,?>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis G: <rainy,?,?,weak,?,change>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,cool,high,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis G: <?,warm,high,?,?,?>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,cool,normal,weak,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis G: <?,warm,high,?,?,?>
hypothesis G: <?,cool,?,?,cool,?>
hypothesis G: <?,?,?,?,cool,same>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,cool,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis G: <?,warm,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,cool,high,strong,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <?,warm,?,?,warm,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis G: <?,warm,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,high,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,warm,normal,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <cloudy,?,?,?,?,same>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,cool,normal,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,warm,high,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,warm,normal,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,cool,high,strong,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,cool,normal,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <?,warm,?,weak,?,?>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,normal,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <sunny,?,?,?,?,change>
hypothesis G: <?,warm,high,weak,?,?>
hypothesis G: <?,warm,?,weak,warm,?>
hypothesis G: <?,warm,?,weak,?,change>
hypothesis G: <sunny,?,high,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,cool,high,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis G: <?,warm,high,weak,?,?>
hypothesis G: <?,warm,?,weak,warm,?>
hypothesis G: <?,warm,?,weak,?,change>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,high,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis G: <sunny,?,?,?,cool,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,cool,high,strong,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,high,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,high,weak,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,cool,high,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,cool,normal,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,normal,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,warm,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,cool,high,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <rainy,cool,normal,weak,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,cool,normal,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,warm,normal,weak,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <cloudy,cool,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,cool,high,strong,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,high,weak,warm,change>
training example: <sunny,warm,normal,strong,warm,same> true
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,warm,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <sunny,cool,normal,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,warm,high,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <sunny,warm,normal,strong,warm,change> true
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,warm,high,strong,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,warm,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,normal,weak,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,cool,high,weak,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,cool,high,weak,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,cool,high,strong,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,normal,strong,warm,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <sunny,cool,high,strong,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <sunny,warm,high,weak,warm,change> true
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,normal,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,high,weak,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <cloudy,cool,normal,strong,cool,change> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,high,strong,cool,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <rainy,cool,normal,strong,warm,same> false
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,warm,?>
training example: <sunny,warm,normal,strong,cool,change> true
hypothesis G: <sunny,warm,?,?,?,?>
hypothesis S: <sunny,warm,?,?,?,?>