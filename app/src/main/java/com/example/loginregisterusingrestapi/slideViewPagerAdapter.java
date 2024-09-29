package com.example.loginregisterusingrestapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class slideViewPagerAdapter extends PagerAdapter {
    Context ctx;

    public slideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboarding_first,container,false);

        ImageView onboardingImage = view.findViewById(R.id.onboardingImage);

        TextView onboardingHading = view.findViewById(R.id.onboardingHading);
        TextView OnboardingTittle = view.findViewById(R.id.OnboardingTittle);
        ImageView dot1 = view.findViewById(R.id.dot1);
        ImageView dot2 = view.findViewById(R.id.dot2);
        ImageView dot3 = view.findViewById(R.id.dot3);

        TextView Login = view.findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });

        Button OnboardingButton = view.findViewById(R.id.OnboardingButton);

        switch (position){
            case 0:
                onboardingImage.setImageResource(R.drawable.backround);
                onboardingHading.setText("Quality");
                OnboardingTittle.setText("Sell your farm fresh products directly to consumers, cutting out the middleman and reducing emissions of the global supply chain. ");
                dot1.setImageResource(R.drawable.greendot);
                dot2.setImageResource(R.drawable.dot);
                dot3.setImageResource(R.drawable.dot);
                break;
            case 1:
                onboardingImage.setImageResource(R.drawable.onboarding_second);
                onboardingHading.setText("Convenient");
                OnboardingTittle.setText("Our team of delivery drivers will make sure your orders are picked up on time and promptly delivered to your customers.");
                dot1.setImageResource(R.drawable.dot);
                dot2.setImageResource(R.drawable.reddot);
                dot3.setImageResource(R.drawable.dot);
                view.setBackgroundColor(ctx.getResources().getColor(R.color.Primary));  // Example using color resource
                OnboardingButton.setBackgroundColor(ctx.getResources().getColor(R.color.Primary));  // Example using a color resource

                break;
            case 2:
                onboardingImage.setImageResource(R.drawable.onboarding_third);
                onboardingHading.setText("Local");
                OnboardingTittle.setText("We love the earth and know you do too! Join us in reducing our local carbon footprint one order at a time. ");
                dot1.setImageResource(R.drawable.dot);
                dot2.setImageResource(R.drawable.dot);
                dot3.setImageResource(R.drawable.yekkowdot);
                view.setBackgroundColor(ctx.getResources().getColor(R.color.Secondary));
                OnboardingButton.setBackgroundColor(ctx.getResources().getColor(R.color.Secondary));  // Example using a color resource

                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);  // Remove the view from the container
    }
}
