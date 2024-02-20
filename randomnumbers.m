% Generate 100 random numbers
random_numbers = randi([1, 100], 1, 100);

% Plot the random numbers
figure;
plot(random_numbers);
title('Plot of 100 Random Numbers');
xlabel('Index');
ylabel('Value');

% Check whether each number is odd or even
for i = 1:length(random_numbers)
    if mod(random_numbers(i), 2) == 0
        fprintf('%d is even.\n', random_numbers(i));
    else
        fprintf('%d is odd.\n', random_numbers(i));
    end
end
