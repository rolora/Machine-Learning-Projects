A = csvread('C:\Users\Roxie\eclipse-workspace\Machine Learning\src\neuron.csv');
x1 = A(1, :);
x2 = A(2, :);
c = A(3, :);

size = length(x1);

figure();
hold on

% Plot the points
for i = 1 : size
    if c(i) == 1
        plot(x1(i), x2(i), 'b+');
    else
        plot(x1(i), x2(i), 'bo');
    end
end

% Plot the calculated line
w = [A(4,1) A(4,2) A(4,3)];
wx1 = [-50, 50];
wx2 = [-(w(1)-w(2)*50)/w(3), -(w(1)+w(2)*50)/w(3)];
plot(wx1, wx2, 'k-');

% Plot the actual line
wActual = [-2 1 2];
wActualx1 = [-50, 50];
wActualx2 = [-(-2-1*50)/2, -(-2+1*50)/2];
plot(wActualx1, wActualx2, 'r-');